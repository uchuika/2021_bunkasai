package com.uchuika.Game.code;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class SplashScrn extends JFrame {

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public static void SplashScrn() {
		
		JFrame splash = new JFrame();
	
		//ムービー再生パネル
		//引数にはファイルのパスを指定してください。
		MoviePanel mp = new MoviePanel("sample.mp4");
 
		//JavaFX動画インスタンスとプレイヤーを取得
		Media meida = mp.getMedia();
		MediaPlayer player = mp.getPlayer();
 
		//読み込み待ち
		for(int i = 0;player.getStatus() != MediaPlayer.Status.READY;i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			
		}
 
		//読み込み完了後なら動画サイズを取得できる
		int videoW = meida.getWidth();
		int videoH = meida.getHeight();
 
		//MoviePanelのサイズを動画に合わせてJFrameに追加
		mp.setPreferredSize(new Dimension(videoW,videoH));
		splash.add(mp);
 
		//JFrame側のパネルサイズを動画に合わせる
		splash.getContentPane().setPreferredSize(new Dimension(videoW,videoH));
 
		//JFrameサイズをパネル全体が見えるサイズに自動調整
		splash.pack();
 
		//中心に表示
		splash.setLocationRelativeTo(null);
 
		splash.setVisible(true);
 
		//動画の再生
		player.play();
	}

}

class MoviePanel extends JFXPanel{
	Media media;
	MediaPlayer player;
	MoviePanel(String filePath){
 
		//JavaFXルートパネル
		StackPane root = new StackPane();
 
		// 動画ファイルのパスを取得
		File f = new File( filePath );
 
		// 動画再生クラスをインスタンス化
		media = new Media( f.toURI().toString() );
		player = new MediaPlayer(media);
		MediaView mediaView = new MediaView(player);
		root.getChildren().add(mediaView);
 
		//JavaFXScene
		Scene scene = new Scene( root );
 
		//JFXPanelにSceneをセット
		setScene(scene);
	}
 
	public Media getMedia() {
		return media;
	}
 
	public MediaPlayer getPlayer() {
		return player;
	}
}

