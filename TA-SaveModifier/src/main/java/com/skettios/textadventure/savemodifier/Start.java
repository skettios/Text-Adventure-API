package com.skettios.textadventure.savemodifier;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Text Adventure API Save Modifier");

		primaryStage.show();
	}
}
