package com.github.xuzw.forexroo.crm.ui.main.dealer;

import com.github.xuzw.forexroo.crm.ui.main.dealer.menu.MenuContainer;
import com.github.xuzw.forexroo.crm.ui.main.dealer.table.Table;
import com.github.xuzw.ui_engine_runtime.div.container.YList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午1:43:53
 */
public class DealerContainer extends YList {
    public DealerContainer() {
        add(new MenuContainer());
        add(new Table());
    }
}
