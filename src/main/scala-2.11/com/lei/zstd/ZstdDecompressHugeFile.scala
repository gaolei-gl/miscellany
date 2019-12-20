package com.lei.zstd

import java.io.File
import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.StandardOpenOption
import java.util.UUID
import com.github.luben.zstd.ZstdDirectBufferDecompressingStream

object ZstdDecompressHugeFile {
  def main(args: Array[String]): Unit = {
    val file = new File("/Users/lgaoa/data.txt.zst")

    val channel = FileChannel.open(file.toPath, StandardOpenOption.READ)
    val readBuffer = ByteBuffer.allocateDirect(4096)
    readBuffer.clear().flip()
    val zis = new ZstdDirectBufferDecompressingStream(readBuffer) {
      override protected def refill(toRefill: ByteBuffer): ByteBuffer = {
        toRefill.clear()
        channel.read(toRefill)
        toRefill.flip()
        toRefill
      }
    }

    val outBuffer = ByteBuffer.allocateDirect(4096 * 1000)
    val aFile = new RandomAccessFile(s"/Users/lgaoa/${UUID.randomUUID()}.txt", "rw")
    val outChannel = aFile.getChannel

    while (zis.hasRemaining) {
      outBuffer.clear()
      zis.read(outBuffer)
      outBuffer.flip()
      while (outBuffer.remaining() > 0) {
        outChannel.write(outBuffer)
      }
    }
    outChannel.close()
  }
}
