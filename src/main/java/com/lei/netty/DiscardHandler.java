package com.lei.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

/**
 * Created by Lei on 2017/7/17.
 */
@ChannelHandler.Sharable
public class DiscardHandler extends ChannelInboundHandlerAdapter {
    ByteBuf buf = null;

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        buf.release();
        buf = null;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        buf = ctx.alloc().buffer(1);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        System.out.println(buf.toString(io.netty.util.CharsetUtil.US_ASCII));
        buf.writeBytes(m);
        ReferenceCountUtil.release(m);
        if (buf.readableBytes() >= 4) {
            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }

//    @Override
//    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
//        final ByteBuf buf = ctx.alloc().directBuffer(4);
//        buf.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//        final ChannelFuture channelFuture = ctx.writeAndFlush(buf);
//        channelFuture.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                ctx.close();
//            }
//        });
//    }
}
