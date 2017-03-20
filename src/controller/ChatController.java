package controller;

import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import model.ChatModel;
import model.Song;
import view.ChatBoxView;
import view.ChatSendEvent;
import view.ChatSendListener;
import view.PrimaryView;

public class ChatController {

	private ChatBoxView chatBoxView;
	// private String username;

	public ChatController(PrimaryView primaryView, CommandController commandCtrl) {
		chatBoxView = new ChatBoxView();

		chatBoxView.setChatSendListener(new ChatSendListener() {

			@Override
			public void chatSend(ChatSendEvent event) {
				commandCtrl.chat(event.getMessageText());
			}

		});
	}

	public void show() {
		chatBoxView.show();
	}

	public void addChatModelChangedListener(ChatModel chat) {
		chat.getChatList().addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(Change<? extends String> change) {
				chatBoxView.addMessage(chat.getChatList().remove(0));
			}
		});
	}

}