package com.tibco.amf.runtime.implementationtype.webapp;

import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.Transaction;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.tibco.bpm.amf.web.Utils;
import com.tibco.amf.platform.runtime.extension.context.ComponentContext;

@Weave
public abstract class WebAppMessageEndpointWrapper {

	
	private final ComponentContext componentContext = Weaver.callOriginal();
	
	@Trace(dispatcher=true)
	public void service(ServletRequest req, ServletResponse res) {
		Transaction transaction = NewRelic.getAgent().getTransaction();
		if(!transaction.isWebTransaction()) {
			transaction.convertToWebTransaction();
		}
		if(componentContext != null) {
			List<String> names = Utils.getTransactionComponents(componentContext);
			String[] txnNames = new String[names.size()];
			
			transaction.setTransactionName(TransactionNamePriority.CUSTOM_LOW, true, "Tibco", txnNames);
			
		}
		
		Weaver.callOriginal();
	}
	
	@Trace
	public void invoke(Subject authSubject, ServletRequest request, ServletResponse response) {
		if(componentContext != null) {
			List<String> names = Utils.getTransactionComponents(componentContext);
			names.add(0, "Custom");
			String[] metricNames = new String[names.size()];
			names.toArray(metricNames);
			NewRelic.getAgent().getTracedMethod().setMetricName(metricNames);
		}
		
		Weaver.callOriginal();
	}
	
}
