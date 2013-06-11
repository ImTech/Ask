/**
 * douzifly @2013-6-6
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui;

/**
 * 
 * define interactive with dock bar
 * @author douzifly
 *
 */
public interface IDockFragment {
    
    public void setDockListener(DockListener l);
    public void setSelected(int position);
    public int  getBarHeight();
    
    public interface DockListener{
        void onDockItemClicked(int position);
        void onDockCenterItemClicked();
    }
}
