import javax.swing.JFrame;

public class Window {

    private String m_winName;
    private int m_width;
    private int m_height;
    private JFrame m_win = new JFrame();

    
    public Window(String Name, int width, int height) {
        this.m_winName = Name;
        this.m_width = width;
        this.m_height = height; 

        m_win.setTitle(m_winName);
        m_win.setSize(m_width, m_height);
    }    
    
    public void Display() {
        m_win.setVisible(true);
    }
    
    public boolean IsWindowClosed() { 
        return false; 
    }

    public JFrame getWindow() { return m_win; }   
}