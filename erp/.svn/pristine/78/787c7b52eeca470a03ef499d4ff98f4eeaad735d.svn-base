package com.ihk.utils.contract.unit;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;

import java.math.BigDecimal;

/**
 * 明细
 * @author dtc
 * 2013-1-10,下午03:29:07
 */
public class ContractDetailUtils {

    /**
     * 获取销售单价
     * @param unit
     * @return
     */
    public static String getBuildPrice(PropertyUnit unit){

        String retPrice = "-";

        try{
            if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
                //成交
                retPrice = unit.getConfirm().getBuildPrice().toString();

            }else if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
                //合同
                retPrice = unit.getContract().getBuildPrice().toString();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return retPrice;
    }

    /**
     * 获取销售总价
     * @param unit
     * @return
     */
    public static String getSumMoney(PropertyUnit unit){

        String retPrice = "-";

        try{
            if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
                //成交
                retPrice = unit.getConfirm().getSumMoney().toString();

            }else if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
                //合同
                retPrice = unit.getContract().getSumMoney().toString();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return retPrice;
    }

    /**
     * 获取应收金额
     * @param unit PropertyUnit
     * @return String
     */
    public static String getShouldAmount(PropertyUnit unit){
        String retPrice = "-";

        try{

            if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
                //成交
                BigDecimal shouldAmount = unit.getConfirm().getShouldAmount();
                if (shouldAmount!=null){
                    retPrice = shouldAmount.toString();
                } else {
                    retPrice = "-";
                }

            }else if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
                //合同
                BigDecimal shouldAmount = unit.getContract().getShouldAmount();
                if (shouldAmount!=null){
                    retPrice = shouldAmount.toString();
                } else {
                    retPrice = "-";
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return retPrice;
    }

    /**
     * 获取实收金额
     * @param unit PropertyUnit
     * @return String
     */
    public static String getPaymentAmount(PropertyUnit unit){
        String retPrice = "-";

        try{
            if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
                //成交
                BigDecimal paymentAmount = unit.getConfirm().getPaymentAmount();
                if (paymentAmount!=null){
                    retPrice = paymentAmount.toString();
                } else {
                    retPrice = "-";
                }

            }else if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
                //合同
                BigDecimal paymentAmount = unit.getContract().getPaymentAmount();
                if (paymentAmount!=null){
                    retPrice = paymentAmount.toString();
                } else {
                    retPrice = "-";
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return retPrice;
    }

}
