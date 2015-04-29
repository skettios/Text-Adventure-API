package com.skettios.textadventure.api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextAdventureUI extends JFrame
{
	private JPanel mainPanel;
	private JTextArea consoleArea;
	private JTextField consoleField;
	private JButton button;

	public TextAdventureUI(String title)
	{
		mainPanel = new JPanel();
		consoleArea = new JTextArea();
		consoleField = new JTextField();
		button = new JButton("Enter");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(title);
		setMaximumSize(new Dimension(800, 600));
		setSize(800, 600);

		consoleArea.setPreferredSize(new Dimension(775, 525));
		consoleArea.setEditable(false);
		consoleArea.setLineWrap(true);

		consoleField.setPreferredSize(new Dimension(674, 25));

		button.setPreferredSize(new Dimension(99, 25));

		mainPanel.add(consoleArea);
		mainPanel.add(consoleField);
		mainPanel.add(button);

		add(mainPanel);
	}

	public void start(final TextAdventureContainer container)
	{
		setVisible(true);

		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				container.parseCommand(consoleField.getText());
				consoleField.setText("");
			}
		});

		consoleField.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					container.parseCommand(consoleField.getText());
					consoleField.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
		});
	}

	public void sendMessage(String message)
	{
		if (message.endsWith("\n") || message.endsWith("\r\n"))
			return;

		consoleArea.append(message + "\n");
	}

	public void clearConsole()
	{
		consoleArea.setText("");
	}
}
