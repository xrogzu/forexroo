package com.github.xuzw.forexroo.crm.ui.main.dealer.table;

import com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging.PagingContainer;
import com.github.xuzw.ui_engine_runtime.div.container.YList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午5:34:40
 */
public class TableContainer extends YList {
    public TableContainer() {
        add(new Table());
        add(new PagingContainer());
    }
}
