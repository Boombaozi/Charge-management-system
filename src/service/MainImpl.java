package service;

import dao.ClientDaoImpl;
import dao.CrDao;
import dao.CrDaoImpl;
import dao.PmDaoImpl;

import domain.*;

import java.sql.Date;
import java.sql.SQLException;

public class MainImpl implements Main {


    @Override
    public void settle1(Cr cr) {
        CrDaoImpl crDao = new CrDaoImpl();                //创建cr实现类对象

        Pm pm = new Pm();                                //创建pm实体
        PmDaoImpl pmDao = new PmDaoImpl();               //创建pm实现类对象

        client client = new client();                     //创建客户实体
        ClientDaoImpl clientDao = new ClientDaoImpl();     //创建clientDao实现类对象

        pm.setCno(cr.getCno());                          //pm得到客户号及日期     值传递
        pm.setDate(cr.getDate());

        client.setCno(cr.getCno());                       //client 得到客户号     值传递

        try {
            pm = pmDao.findPmById(pm);                         //得到Pm信息
            client = clientDao.findClientById(client);              //得到客户信息
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String a;
        a = pm.getSign();
        if (a.equals("未收")) {
            float jiesuan;
            jiesuan = (client.getMoney() - pm.getCharge());
            client.setMoney(jiesuan);
            pm.setSign("已收");
            cr.setSc(pm.getCharge());
            cr.setAc(pm.getCharge());
            cr.setEno("系统");


            try {
                pmDao.updatePmsign(pm);
                crDao.addCr(cr);
                clientDao.updateClient(client);

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {

            cr.setSc(0);
            cr.setAc(0);
            cr.setEno("错误");
            try {
                crDao.addCr(cr);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public void pay1(Cr cr) {

        CrDaoImpl crDao = new CrDaoImpl();                //创建cr实现类对象

        Pm pm = new Pm();                                //创建pm实体
        PmDaoImpl pmDao = new PmDaoImpl();               //创建pm实现类对象

        client client = new client();                     //创建客户实体
        ClientDaoImpl clientDao = new ClientDaoImpl();     //创建clientDao实现类对象

        pm.setCno(cr.getCno());                          //pm得到客户号及日期     值传递
        pm.setDate(cr.getDate());

        client.setCno(cr.getCno());                       //client 得到客户号     值传递

        try {
            client = clientDao.findClientById(client);
            pm = pmDao.findPmById(pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String a;
        a = pm.getSign();


        if (a.equals("未收")) {
            cr.setSc(pm.getCharge() - client.getMoney());              //应收
            client.setMoney((cr.getAc() + client.getMoney()) - pm.getCharge());  //剩余金额
            pm.setSign("已收");                                         //修改收费标志
            try {
                pmDao.updatePmsign(pm);            //执行更新
                clientDao.updateClient(client);   //执行更新
                crDao.addCr(cr);                  //生成缴费记录
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            client.setMoney(client.getMoney() + cr.getAc()); //账户余额计算
            cr.setSc(0);

            try {
                clientDao.updateClient(client);                      //执行更新
                crDao.addCr(cr);                                 //产生订单

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public void pay2(Cr cr) {

      CrDaoImpl crDao=new CrDaoImpl();                //
      ClientDaoImpl clientDao=new ClientDaoImpl();    //


      client client=new client();                     //创建实体


        client.setCno(cr.getCno());                     //



        try {
            client=clientDao.findClientById(client);
            float jiesuan = (cr.getAc()+client.getMoney());
            cr.setSc(0);
            client.setMoney(jiesuan);
            clientDao.updateClient(client);
            crDao.addCr2(cr);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void ceshicr(Cr cr) {
        CrDaoImpl crDao = new CrDaoImpl();

        Pm pm = new Pm();
        PmDaoImpl pmDao = new PmDaoImpl();

        client client = new client();
        ClientDaoImpl clientDao = new ClientDaoImpl();

        pm.setCno(cr.getCno());//pm得到客户号及日期
        pm.setDate(cr.getDate());

        client.setCno(cr.getCno());//client 得到客户号

        cr.setSc(8888);
        cr.setAc(9999);
        cr.setEno("系统");


        try {
            crDao.addCr(cr);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void ceshipm(Cr cr) {

        CrDaoImpl crDao = new CrDaoImpl();                //创建cr实现类对象

        Pm pm = new Pm();                                //创建pm实体
        PmDaoImpl pmDao = new PmDaoImpl();               //创建pm实现类对象

        client client = new client();                     //创建客户实体
        ClientDaoImpl clientDao = new ClientDaoImpl();     //创建clientDao实现类对象

        pm.setCno(cr.getCno());                          //pm得到客户号及日期     值传递
        pm.setDate(cr.getDate());

        client.setCno(cr.getCno());                       //client 得到客户号     值传递

        try {
            pm = pmDao.findPmById(pm);
            pm.setSign("已收");
            pmDao.updatePmsign(pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void ceshiclient(Cr cr) {


        CrDaoImpl crDao = new CrDaoImpl();                //创建cr实现类对象

        Pm pm = new Pm();                                //创建pm实体
        PmDaoImpl pmDao = new PmDaoImpl();               //创建pm实现类对象

        client client = new client();                     //创建客户实体
        ClientDaoImpl clientDao = new ClientDaoImpl();     //创建clientDao实现类对象

        pm.setCno(cr.getCno());                          //pm得到客户号及日期     值传递
        pm.setDate(cr.getDate());

        client.setCno(cr.getCno());                       //client 得到客户号     值传递


        try {
            client = clientDao.findClientById(client);
            client.setMoney(20);
            clientDao.updateClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
