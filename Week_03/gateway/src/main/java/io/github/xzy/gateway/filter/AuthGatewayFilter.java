package io.github.xzy.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

public class AuthGatewayFilter extends GatewayFilter{

	@Override
	public boolean doFilter(FullHttpRequest request) {
		HttpHeaders headers = request.headers();
		headers.add("nio", "xuziyang");
		return true;
	}

}
