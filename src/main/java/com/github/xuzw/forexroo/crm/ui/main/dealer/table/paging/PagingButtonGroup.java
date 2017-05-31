package com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging;

import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午5:08:13
 */
public class PagingButtonGroup extends XList {
    public PagingButtonGroup add(int pageIndex) {
        return (PagingButtonGroup) add(new PagingButton(pageIndex));
    }
}
