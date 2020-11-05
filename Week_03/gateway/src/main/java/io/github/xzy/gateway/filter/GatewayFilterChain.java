package io.github.xzy.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;

public class GatewayFilterChain {
	private GatewayFilter head = null;
	private GatewayFilter tail = null;

	public void addFilter(GatewayFilter filter) {
		filter.setSuccessor(null);
		if (head == null) {
			head = filter;
			tail = filter;
			return;
		}
		tail.setSuccessor(filter);
		tail = filter;
	}

	public void filter(FullHttpRequest request){
		if (head != null) {
			head.filter(request);
		}
	}
}
