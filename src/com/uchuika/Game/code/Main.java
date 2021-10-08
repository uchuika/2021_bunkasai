package com.uchuika.Game.code;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class Main extends JFrame {

	
	private JPanel contentPane;
	//フォント定義
	Font keifont = null;

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

	//スプラッシュスクリーンの処理
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
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	//メインwindow
	public Main() {
		
		Font keifont = null;
		
		try{
			keifont = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream("fonts/k-font/keifont.ttf"));
		}catch(FontFormatException e){
			  System.out.println("形式がフォントではありません。");
		}catch(IOException e){
			  System.out.println("入出力エラーでフォントを読み込むことができませんでした。");
		}
		
		 keifont = keifont.deriveFont(27F);
		
		
		//Mainwindowの基本設定
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 608);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 770, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//ストーリーモードのボタン
		Button button = new Button("ストーリーモード");
		button.setFont(new Font("HGS創英角ﾎﾟｯﾌﾟ体", Font.BOLD, 23));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(265, 450, 240, 50);
		panel.add(button);
		
		//設定のボタン
		Button button_2 = new Button("設定");
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(265, 310, 240, 50);
		button_2.setBackground(new Color (241, 57, 83));
		button_2.setFont(new Font("HGS創英角ﾎﾟｯﾌﾟ体", Font.BOLD, 23));
		panel.add(button_2);
		
		//オンラインモードのボタン
		Button button_1 = new Button("オンラインモード");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color (241, 57, 83));
		button_1.setFont(new Font("HGS創英角ﾎﾟｯﾌﾟ体", Font.BOLD, 23));
		button_1.setBounds(265, 380, 240, 50);
		panel.add(button_1);
		
		Button button_3 = new Button("プレイヤーデータ");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.BOLD, 23));
		button_3.setBackground(new Color (241, 57, 83));
		button_3.setBounds(265, 240, 240, 50);
		panel.add(button_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/com/uchuika/Game/PNG/とある部活の鬼ごっこ.png")));
		lblNewLabel.setBounds(0, 0, 770, 560);
		panel.add(lblNewLabel);
		
		setVisible(true);
	}
}
