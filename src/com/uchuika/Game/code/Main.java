package com.uchuika.Game.code;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		//スプラッシュスクリーン発動
		SplashScrn();
		
		/*
		//五秒待機
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			System.out.println("起動に失敗しました。");
		}
		*/	
		
		new Main();
		
	}


	public static void SplashScrn() {
		
		int result = 0;
		
		JFrame splash = new JFrame();
	
		//ムービー再生パネル
		//引数にはファイルのパスを指定してください。
		MoviePanel mp = new MoviePanel("sample.mp4");
 
		//JavaFX動画インスタンスとプレイヤーを取得
		Media meida = mp.getMedia();
		MediaPlayer player = mp.getPlayer();
		Status status = player.getStatus();
 
		//読み込み待ち
		for(int i = 0;player.getStatus() != MediaPlayer.Status.READY;i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			//起動結果が例外だった場合はwindowが起動しない
			result = 0;
		}
 
		//読み込み完了後なら動画サイズを取得できる
		int videoW = meida.getWidth();
		int videoH = meida.getHeight();
 
		//MoviePanelのサイズを動画に合わせてJFrameに追加
		mp.setPreferredSize(new Dimension(videoW,videoH));
		splash.getContentPane().add(mp);
 
		//JFrame側のパネルサイズを動画に合わせる
		splash.getContentPane().setPreferredSize(new Dimension(videoW,videoH));
 
		//JFrameサイズをパネル全体が見えるサイズに自動調整
		splash.pack();
 
		//中心に表示
		splash.setLocationRelativeTo(null);
 
		splash.setVisible(true);
 
		//動画の再生
		player.play();
		
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			System.out.println("起動に失敗しました。");
		}	
		
		
		//非表示
		splash.setVisible(false);
		
		//window削除
		splash.dispose();
		
	}



	/**
	 * Create the frame.
	 */
	public Main() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 608);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 770, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button = new Button("ストーリーモード");
		button.setFont(new Font("HGS創英角ﾎﾟｯﾌﾟ体", Font.BOLD, 18));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(265, 450, 240, 50);
		panel.add(button);
		
		Button button_1 = new Button("オンラインモード");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color (241, 57, 83));
		button_1.setFont(new Font("HGS創英角ﾎﾟｯﾌﾟ体", Font.BOLD, 18));
		button_1.setBounds(265, 380, 240, 50);
		panel.add(button_1);
		
		setVisible(true);
	}
}
