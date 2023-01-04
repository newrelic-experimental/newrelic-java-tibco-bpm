package com.tibco.amf.spline.api.processor.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.spline.SplineUtil;
import com.tibco.amf.spline.api.context.IDispatchContext;
import com.tibco.amf.spline.api.context.ISplineExchange;

@Weave(type=MatchType.Interface)
public abstract class IRoutingWorker {

	@SuppressWarnings("rawtypes")
	@Trace
	public IDispatchContext route(ISplineExchange splineExchange) {
		String[] serviceNames = SplineUtil.getServiceNames(splineExchange);
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","IRoutingWorker",getClass().getName(),"route",serviceNames[0],serviceNames[1]});
		return Weaver.callOriginal();
	}
}
