package com.tibco.amf.binding.soap.runtime.transport.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.transaction.TransactionManager;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public class MessageSender {

	@Trace
	public Message send(JmsTransportProperties properties, Destination destination, MessageCreator messageCreator, boolean xa_transaction, TransactionManager tm, Connection connection) {
		return Weaver.callOriginal();
	}
	
	@Trace
	public Message sendReceive(JmsTransportProperties properties, MessageCreator messageCreator, Destination replyDestination) {
		return Weaver.callOriginal();
	}
	
	@Trace
	public Message sendReceiveDynamic(JmsTransportProperties properties, MessageCreator messageCreator, Destination replyDestination, Destination dynamicDestination) {
		return Weaver.callOriginal();
	}
	
	
}
