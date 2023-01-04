package com.tibco.mediation.task.rt.internal.impl;

import java.util.List;

import javax.xml.namespace.QName;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.sca.model.extensionpoints.Wsdl11InterfaceContextParameter;
import com.tibco.amsb.core.engine.flow.manager.OperationNameKey;
import com.tibco.amsb.core.engine.internal.PlatformRequestMessageHolder;
import com.tibco.mediation.task.rt.internal.InternalExchange;
import com.tibco.mediation.task.rt.internal.context.InternalTaskContext;

@Weave
public abstract class TargetOperationCaller<I, U, N extends I, A extends I, S, T, X> {

	public abstract QName getTargetOperationQName();
	
	public void sendRequestForInvokeOperationMediationTask(InternalExchange<I, U, N, A, S, T, X> mediationExchange, InternalTaskContext<I, U, N, A, S, T, X> taskContext,
			PlatformRequestMessageHolder<I, U, N, A, S, T, X> targetOperationRequestMessage, List<Wsdl11InterfaceContextParameter> contextParameterConfigs, OperationNameKey targetOperationOutputMsgKey,
			OperationNameKey targetOperationFaultMsgKey, String operationName) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","TargetOperationCaller","sendRequestForInvokeOperationMediationTask",operationName);
		Weaver.callOriginal();
	}
	
	public void sendRequestForTargetOperationMediationTask(InternalExchange<I, U, N, A, S, T, X> mediationExchange, InternalTaskContext<I, U, N, A, S, T, X> taskContext,
			PlatformRequestMessageHolder<I, U, N, A, S, T, X> targetOperationRequestMessage, List<Wsdl11InterfaceContextParameter> contextParameterConfigs,
			OperationNameKey targetOperationNameKey, final String targetOperationLocalName) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","TargetOperationCaller","sendRequestForInvokeOperationMediationTask",targetOperationLocalName);
		Weaver.callOriginal();
	}
}
