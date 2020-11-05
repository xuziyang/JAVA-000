package io.github.xzy.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;

public abstract class GatewayFilter {
	protected GatewayFilter successor = null;

	public void setSuccessor(GatewayFilter successor) { this.successor = successor; }

	public final void filter(FullHttpRequest request){
		boolean handled = doFilter(request);
		if (successor != null && !handled) {
			successor.filter(request);
		}
	}

	protected abstract boolean doFilter(FullHttpRequest request);
}
