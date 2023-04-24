package com.he;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import org.springframework.util.ObjectUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test {
    static ModbusMaster modbusMaster;

    public static void initJlibModbusMaster(String ip) {
        // 如果连接不存在，创建一个主机连接
        if (ObjectUtils.isEmpty(modbusMaster)) {
            // 设置主机TCP参数
            TcpParameters tcpParameters = new TcpParameters();
            // 设置TCP的ip地址-本地地址
            InetAddress address = null;
            try {
                address = InetAddress.getByName(ip);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            tcpParameters.setHost(address);
            // TCP设置长连接
            tcpParameters.setKeepAlive(true);
            // TCP设置端口，这里设置是默认端口502
            tcpParameters.setPort(502);
            modbusMaster = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
            Modbus.setAutoIncrementTransactionId(true);
        }
    }

    public static void release() {
        if (modbusMaster != null) {
            try {
                modbusMaster.disconnect();
            } catch (ModbusIOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * "功能码0x04"
     * 读取HoldingRegister数据
     *
     * @param slaveId  寄存器地址ID
     * @param offset   寄存器读取开始地址
     * @param quantity 读取寄存器数量
     * @return int数组
     */
    public static int[] readInputRegisters(int slaveId, int offset, int quantity) {
        try {
            return modbusMaster.readInputRegisters(slaveId, offset, quantity);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new RuntimeException(e);
        } finally {
            release();
        }
    }

    /**
     * "功能码0x03"
     * 读取HoldingRegister数据
     *
     * @param slaveId  寄存器地址ID
     * @param offset   寄存器读取开始地址
     * @param quantity 读取寄存器数量
     * @return int数组
     */
    public static int[] readHoldingRegisters(int slaveId, int offset, int quantity) {
        try {
            return modbusMaster.readHoldingRegisters(slaveId, offset, quantity);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new RuntimeException(e);
        } finally {
            release();
        }
    }
    public static void main(String[] args) {

        //连接初始化
        initJlibModbusMaster("127.0.0.1");

        Object lock = new Object();

        //读取前三个数据
        new Thread(() -> {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 3; i++) {
                        int[] values2 = readHoldingRegisters(1, i, 1);
                        System.out.println(Arrays.toString(values2));
                        System.out.println("当前线程的名称：" + Thread.currentThread().getName());
                    }
                    lock.notify();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }, "ReadThread").start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    //写入数据
                    modbusMaster.writeSingleRegister(1, 3, 100);
                    System.out.println("当前线程的名称：" + Thread.currentThread().getName());
                    lock.wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }, "WriteThread").start();

        System.out.println("当前线程的名称：" + Thread.currentThread().getName());
        System.out.println("当前线程的名称：" + Thread.currentThread().getName());


        //多个线程时，保证线程的执行顺序
//        CountDownLatch latch1 = new CountDownLatch(1);
//        CountDownLatch latch2 = new CountDownLatch(1);
//        Thread t1 = new Thread(() -> {
//            // 线程 1 的代码
//            System.out.println("Thread 1 is running");
//            latch1.countDown(); // 计数器减 1
//        });
//        Thread t2 = new Thread(() -> {
//            try {
//                latch1.await(); // 等待计数器为 0
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 线程 2 的代码
//            System.out.println("Thread 2 is running");
//            latch2.countDown(); // 计数器减 1
//        });
//        Thread t3 = new Thread(() -> {
//            try {
//                latch2.await(); // 等待计数器为 0
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 线程 3 的代码
//            System.out.println("Thread 3 is running");
//        });
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
