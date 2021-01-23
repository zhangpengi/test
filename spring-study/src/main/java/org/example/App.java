package org.example;
import org.example.config.AppConfig;
import org.example.controller.LoginController;
import org.example.dao.LoginDAO;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
    public static void main(String[] args) {
        //根据Spring配置文件路径创建容器：应用上下文对象
        ApplicationContext context = new
                ClassPathXmlApplicationContext("beans.xml");

        //获取注册的 Bean 对象：根据名称获取，根据类型获取
        LoginController loginController = (LoginController)context.getBean("loginController");//名称获取
        LoginController loginController1 = context.getBean(LoginController.class);//类型获取

        //获取Service，DAO的对象:通过类型获取
        LoginService loginService = (LoginService)context.getBean("loginService");
        LoginService loginService1 = context.getBean(LoginService.class);

        LoginDAO loginDAO = context.getBean(LoginDAO.class);
        LoginDAO loginDAO1 = (LoginDAO)context.getBean("loginDAO");

        AppConfig appConfig = context.getBean(AppConfig.class);

        User user = (User)context.getBean("byFactoryBean");

        //打印
        System.out.println(loginController == loginController1);
        System.out.println(loginService == loginService1);
        System.out.println(loginDAO );

        System.out.println(loginController.user1());
        System.out.println(loginController.user2());

        System.out.println(appConfig);
        System.out.println(user);


        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}