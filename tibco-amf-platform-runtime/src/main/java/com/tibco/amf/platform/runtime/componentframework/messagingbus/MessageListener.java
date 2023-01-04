package com.tibco.amf.platform.runtime.componentframework.messagingbus;

import java.util.Map;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class MessageListener<M> {
	
	@Trace(dispatcher=true)
	public void onRemoteMessage(M msg, Map<String, Object> props, MessagingContext msgCtx) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MessageListener",getClass().getSimpleName(),"onRemoteMessage");
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public void onRemoteException(Exception var1, Map<String, Object> var2, MessagingContext var3) {
		NewRelic.noticeError(var1);
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MessageListener",getClass().getSimpleName(),"onRemoteException");
		Weaver.callOriginal();
	}

}
