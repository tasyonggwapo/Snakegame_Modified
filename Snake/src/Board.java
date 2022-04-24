package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 330;
    private final int B_HEIGHT = 330;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 20;
    private final int DELAY = 45;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;
    private int applecopy_x;
    private int applecopy_y;
    private int apple2_x;
    private int apple2_y;
    private int apple22_x;
    private int apple22_y;
    private int apple3_x;
    private int apple3_y;
    private int apple33_x;
    private int apple33_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image applecopy;
    private Image apple2;
    private Image apple22;
    private Image apple3;
    private Image apple33;
    private Image head;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iia1 = new ImageIcon("src/resources/applecopy.png");
        applecopy = iia1.getImage();

        ImageIcon iib = new ImageIcon("src/resources/apple2.png");
        apple2 = iib.getImage();

        ImageIcon iib1 = new ImageIcon("src/resources/apple22.png");
        apple22 = iib1.getImage();

        ImageIcon iic = new ImageIcon("src/resources/apple3.png");
        apple3 = iic.getImage();

        ImageIcon iic1 = new ImageIcon("src/resources/apple33.png");
        apple33 = iic1.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();
        locateApplecopy();
        locateApple2();
        locateApple22();
        locateApple3();
        locateApple33();

        timer = new Timer(DELAY, this);
        timer.start();


    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            g.drawImage(applecopy, applecopy_x, applecopy_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            g.drawImage(apple2, apple2_x, apple2_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            g.drawImage(apple22, apple22_x, apple22_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }


            g.drawImage(apple3, apple3_x, apple3_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            g.drawImage(apple33, apple33_x, apple33_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }
    }


    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            locateApple();
        }
    }

    private void checkApplecopy() {

        if ((x[0] == applecopy_x) && (y[0] == applecopy_y)) {

            dots--;
            locateApplecopy();
        }
    }

    private void checkApple2() {

        if ((x[0] == apple2_x) && (y[0] == apple2_y)) {

            dots++;
            locateApple2();
        }
    }

    private void checkApple22() {

        if ((x[0] == apple22_x) && (y[0] == apple22_y)) {

            dots--;
            locateApple22();
        }
    }

    private void checkApple3() {

        if ((x[0] == apple3_x) && (y[0] == apple3_y)) {

            dots++;
            locateApple3();
        }
    }

    private void checkApple33() {

        if ((x[0] == apple33_x) && (y[0] == apple33_y)) {

            dots--;
            locateApple33();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    private void locateApplecopy() {

        int r = (int) (Math.random() * RAND_POS);
        applecopy_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        applecopy_y = ((r * DOT_SIZE));
    }

    private void locateApple2() {

        int r = (int) (Math.random() * RAND_POS);
        apple2_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple2_y = ((r * DOT_SIZE));
    }

    private void locateApple22() {

        int r = (int) (Math.random() * RAND_POS);
        apple22_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple22_y = ((r * DOT_SIZE));
    }

    private void locateApple3() {

        int r = (int) (Math.random() * RAND_POS);
        apple3_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple3_y = ((r * DOT_SIZE));
    }

    private void locateApple33() {

        int r = (int) (Math.random() * RAND_POS);
        apple33_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple33_y = ((r * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkApplecopy();
            checkApple2();
            checkApple22();
            checkApple3();
            checkApple33();
            checkCollision();
            move();
        }

        repaint();
    }


    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
