package com.tibco.amf.binding.soap.runtime;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import org.osoa.sca.ServiceRuntimeException;

@Weave(type=MatchType.Interface)
public abstract class SoapCallbackInterface {
	
	@NewField
	public Token token = null;
	
	@Trace(async=true)
	public void onException(ServiceRuntimeException var1) {
		NewRelic.noticeError(var1);
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		Weaver.callOriginal();
	}

	@Trace(async=true)
	void onCompletion(RequestContext var1) {
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		Weaver.callOriginal();
	}


}
