package io.github.xzy.gateway.outbound;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HttpOutBoundHandler {

	private static Logger logger = LoggerFactory.getLogger(HttpOutBoundHandler.class);

	private static final String BACK_URL = "http://localhost:8801";

	public void handler(ChannelHandlerContext ctx, FullHttpRequest fullRequest) {
		FullHttpResponse fullHttpResponse = null;
		try {
			fullHttpResponse = doRequestBack(fullRequest);
		} catch (Exception e) {
			//logger.error("处理测试接口出错", e);
			fullHttpResponse = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
			exceptionCaught(ctx, e);
		} finally {
			if (fullRequest != null) {
				if (!HttpUtil.isKeepAlive(fullRequest)) {
					ctx.write(fullHttpResponse).addListener(ChannelFutureListener.CLOSE);
				} else {
					fullHttpResponse.headers().set(CONNECTION, KEEP_ALIVE);
					ctx.write(fullHttpResponse);
				}
			}
		}
	}

	private FullHttpResponse doRequestBack(FullHttpRequest fullRequest) throws IOException {
		// 创建http GET请求
		HttpGet httpGet = new HttpGet(BACK_URL);
		setHeaders(fullRequest, httpGet);

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			// 判断返回状态是否为200
			byte[] body = EntityUtils.toByteArray(response.getEntity());
			FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
			fullHttpResponse.headers().set("Content-Type", "application/json");
			fullHttpResponse.headers().setInt("Content-Length", body.length);

			return fullHttpResponse;
		}
	}

	private void setHeaders(FullHttpRequest fullRequest, HttpGet httpGet) {
		List<Map.Entry<String, String>> entries = fullRequest.headers().entries();
		for (Map.Entry<String, String> entry : entries) {
			httpGet.addHeader(entry.getKey(),entry.getValue());
		}
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
