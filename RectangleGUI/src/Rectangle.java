public class Rectangle {
    
    private int m_length;
    private int m_width;

    private String m_null = " ";
    private String m_dash = "-";
    
    public Rectangle(int length, int width) {
        this.m_length = length;
        this.m_width = width;
        
        Area();

        DrawGUI();
    }

    private void Area() {
        System.out.println(m_length * m_width);
    }

    public void DrawGUI() {
        System.out.println("*" + m_dash.repeat(m_length) + "*");
        for (int i = 0; i < m_width; i++) {
            System.out.println("|" + m_null.repeat(m_width) + "|");
        }
        System.out.println("*" + m_dash.repeat(m_length) + "*");
    } 
}