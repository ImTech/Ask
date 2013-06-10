/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-8
 */
package com.imtech.ask.ui.message;

/**
 * 消息
 */
public class MessageModel {
	public enum Type {
		TOPIC, REPLY, NEWS
	}

	public String title;
	public String summary;
	public Type type;
	public int msgCounts;
}
