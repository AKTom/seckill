package org.seckill.exception;

/**
 * 秒杀关闭异常 (运行期异常）
 * @Author Jeanva He
 * @Date
 */
public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
