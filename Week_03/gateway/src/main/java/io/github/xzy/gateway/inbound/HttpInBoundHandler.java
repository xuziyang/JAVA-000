package io.github.xzy.gateway.inbound;

import io.github.xzy.gateway.filter.AuthGatewayFilter;
import io.github.xzy.gateway.filter.GatewayFilterChain;
import io.github.xzy.gateway.outbound.HttpOutBoundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpInBoundHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private static Logger logger = LoggerFactory.getLogger(HttpInBoundHandler.class);
	private HttpOutBoundHandler outBoundHandler;
	private GatewayFilterChain filterChain;

	public HttpInBoundHandler() {
		super();
		outBoundHandler = new HttpOutBoundHandler();
		filterChain = new GatewayFilterChain();
		filterChain.addFilter(new AuthGatewayFilter());
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest fullRequest)
			throws Exception {
		//logger.info("channelRead流量接口请求开始，时间为{}", startTime);
		String uri = fullRequest.uri();
		//logger.info("接收到的请求url为{}", uri);
		if (uri.contains("/test")) {
			filterChain.filter(fullRequest);
			outBoundHandler.handler(ctx, fullRequest);
		}
	}



}
