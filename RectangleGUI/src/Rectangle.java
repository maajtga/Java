public class Rectangle {
    
    private int m_length;
    private int m_width;

    private char m_star = '*';
    private char m_dash = '-';
    private char m_bar = '|';

    private int m_i;

    private char[] m_GUI = new char[100];
    
    public Rectangle(int length, int width) {
        this.m_length = length;
        this.m_width = width;
        
        System.out.println("Area: " + Area());
        DrawGUI();

        System.out.println(m_GUI);
    }

    private int Area() {
        return m_length * m_width;
    }

    private void DrawGUI() {
        m_GUI[0] = m_star;

        for (m_i = 1; m_i <= m_length + 1; m_i++) {
            m_GUI[m_i] = m_dash;

            if (m_i == m_length + 1) {
                m_GUI[m_i] = m_star;
                m_GUI[m_i + 1] = '\n';
                m_i += 1;
                System.out.println(m_i);
                break;
            }

        }        

        for (m_i += 1; m_i <= m_width; m_i++) {
            m_GUI[m_i] = m_bar;
            System.out.println(m_i);
        }

    }
}
