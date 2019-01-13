

import java.math.BigDecimal;

/**
 * 
 * 四则运算
 *
 * @author lt
 * @version 2018年11月10日上午9:15:02
 */
public class CalcUtils {

	/**
	 * 保留小数位
	 */
	private static final int DEF_DIV_SCALE = 2;

	/**
	 * 结果值
	 */
	private BigDecimal currNum = null;

	private CalcUtils(BigDecimal dcimal) {
		currNum = dcimal;
	}

	/**
	 * 初始化运算对象
	 * 
	 * @param v1
	 * @return
	 */
	public static CalcUtils init(Number v1) {
		Double m1 = Double.valueOf(v1.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		return new CalcUtils(b1);
	}

	/**
	 * 两数直接相加
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static CalcUtils add(Number v1, Number v2) {
		Double m1 = Double.valueOf(v1.toString());
		Double m2 = Double.valueOf(v2.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		BigDecimal b2 = BigDecimal.valueOf(m2);
		return new CalcUtils(b1.add(b2));
	}

	/**
	 * 运算结果后，跟着相加
	 * 
	 * @param v1
	 * @return
	 */
	public CalcUtils add(Number v1) {
		Double m1 = Double.valueOf(v1.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		this.currNum = currNum.add(b1);
		return this;
	}

	/**
	 * 两数直接相减
	 * 
	 * @param v1 减数
	 * @param v2 被减数
	 * @return
	 */
	public static CalcUtils sub(Number v1, Number v2) {
		Double m1 = Double.valueOf(v1.toString());
		Double m2 = Double.valueOf(v2.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		BigDecimal b2 = BigDecimal.valueOf(m2);
		return new CalcUtils(b1.subtract(b2));
	}

	/**
	 * 运算结果后，跟着相减
	 * 
	 * @param v1 减数
	 * @param v2 被减数
	 * @return
	 */
	public CalcUtils sub(Number v1) {
		Double m1 = Double.valueOf(v1.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		this.currNum = currNum.subtract(b1);
		return this;
	}

	/**
	 * 两数直接相乘
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static CalcUtils mul(Number v1, Number v2) {
		Double m1 = Double.valueOf(v1.toString());
		Double m2 = Double.valueOf(v2.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		BigDecimal b2 = BigDecimal.valueOf(m2);
		return new CalcUtils(b1.multiply(b2));
	}

	/**
	 * 运算结果后，跟着相乘
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public CalcUtils mul(Number v1) {
		Double m1 = Double.valueOf(v1.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		this.currNum = currNum.multiply(b1);
		return this;
	}

	/**
	 * 两数直接相除
	 * 
	 * @param v1 除数
	 * @param v2 被除数
	 * @return
	 */
	public static CalcUtils div(Number v1, Number v2) {
		Double m1 = Double.valueOf(v1.toString());
		Double m2 = Double.valueOf(v2.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		BigDecimal b2 = BigDecimal.valueOf(m2);
		// 此处保留20位，减少误差
		return new CalcUtils(b1.divide(b2, 20, BigDecimal.ROUND_HALF_UP));
	}

	/**
	 * 运算结果后，跟着相除
	 * 
	 * @param v1 除数
	 * @param v2 被除数
	 * @return
	 */
	public CalcUtils div(Number v1) {
		Double m1 = Double.valueOf(v1.toString());
		BigDecimal b1 = BigDecimal.valueOf(m1);
		// 此处保留20位，减少误差
		this.currNum = currNum.divide(b1, 20, BigDecimal.ROUND_HALF_UP);
		return this;
	}

	/**
	 * 返回结果,可不传参数
	 * 
	 * @param scale 保留位数，默认2位小数
	 * @return
	 */
	public float floatValue(int... scale) {
		if (scale.length > 0) {
			return currNum.setScale(scale[0], BigDecimal.ROUND_HALF_UP).floatValue();
		}
		return currNum.setScale(DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	/**
	 * 返回结果,可不传参数
	 * 
	 * @param scale 保留位数，默认2位小数
	 * @return
	 */
	public long longValue(int... scale) {
		if (scale.length > 0) {
			return currNum.setScale(scale[0], BigDecimal.ROUND_HALF_UP).longValue();
		}
		return currNum.setScale(DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).longValue();
	}

	/**
	 * 返回结果,可不传参数
	 * 
	 * @param scale 保留位数，默认2位小数
	 * @return
	 */
	public int intValue(int... scale) {
		if (scale.length > 0) {
			return currNum.setScale(scale[0], BigDecimal.ROUND_HALF_UP).intValue();
		}
		return currNum.setScale(DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).intValue();
	}

	/**
	 * 返回结果,可不传参数
	 * 
	 * @param scale 保留位数，默认2位小数
	 * @return
	 */
	public double doubleValue(int... scale) {
		if (scale.length > 0) {
			return currNum.setScale(scale[0], BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return currNum.setScale(DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 返回结果,可不传参数
	 * 
	 * @param scale 保留位数，默认2位小数
	 * @return
	 */
	public short shortValue(int... scale) {
		if (scale.length > 0) {
			return currNum.setScale(scale[0], BigDecimal.ROUND_HALF_UP).shortValue();
		}
		return currNum.setScale(DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).shortValue();
	}

}
