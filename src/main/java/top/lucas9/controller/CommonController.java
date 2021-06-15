package top.lucas9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author lucas
 */
@Controller
public class CommonController {
    @RequestMapping("/checkCode")
    public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width = 800;
        int height = 400;
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.setFont(new Font("", Font.BOLD, 200));
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567989";
        String checkCode = "";
        for (int i = 0; i < 4; i++) {
            Random ran = new Random();
            int index = ran.nextInt(str.length());
            checkCode += String.valueOf(str.charAt(index));
            g.drawString(String.valueOf(str.charAt(index)), 100 + 150 * i, 250);
        }
        HttpSession session = request.getSession();
        session.setAttribute("CHECK_CODE", checkCode);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(10));
        //绘制干扰线;
        graphics2D.setColor(Color.ORANGE);
        //随机生成坐标点
        Random ran = new Random();
        int times = ran.nextInt(10) + 10;
        for (int i = 0; i < times; i++) {
            int xBegin = ran.nextInt(width) + 80;
            int yBegin = ran.nextInt(width) + 80;
            int xEnd = ran.nextInt(height);
            int yEnd = ran.nextInt(height);
            graphics2D.drawLine(xBegin, xEnd, yBegin, yEnd);
        }
        ImageIO.write(img, "jpg", outputStream);
    }
}
