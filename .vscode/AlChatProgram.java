import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AlChatProgram {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private Map<String, List<String>> answerMap;

    public AlChatProgram() {
        frame = new JFrame("AlChatXamlol");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        answerMap = new HashMap<>();

        // Thêm các câu hỏi và câu trả lời vào answerMap
        answerMap.put("hello", List.of("chao ban", "hello lắm thế", "hello cái con căc"));
        answerMap.put("bạn ăn cơm chưa",
                List.of("tôi là người máy không biết ăn cơm", "hỏi cái đầu buồi", "bố đell nói"));
        answerMap.put("chửi cái đầu bùi", List.of("chủi cái éo gì vậy", "thiến cả họ nhà bay", "solo anh cân tất"));
        answerMap.put("lol", List.of("banh ra cho xem", "chấp chú chục cái", "lolllll"));
        answerMap.put("xin chao", List.of("éo chào lại đấy"));
        answerMap.put("có cái con cặc", List.of("cái đầu bùi"));
        answerMap.put("cho mình hỏi cái ", List.of("cái đầu bùi"));
        answerMap.put("bạn biết nhiều không", List.of("không biết cái đell gì cả"));
        answerMap.put("bạn có thể giúp mình được không", List.of("dell and dell"));
        answerMap.put("hãy giúp mình vấn đề này", List.of("không thể vì mình không thể giúp"));
        answerMap.put("cái này đơn giản lắm", List.of("dell and dell muốn giúp"));
        answerMap.put("không biết nên nói gì", List.of("thế thì đừng nói"));
        // Thêm tab câu hỏi 1
        JPanel question1Panel = new JPanel();
        question1Panel.setLayout(new FlowLayout());
        JLabel question1Label = new JLabel("Hỏi đi men :");
        JTextField question1TextField = new JTextField(20);
        JButton question1Button = new JButton("Gửi nào các con cek");
        question1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question1 = question1TextField.getText();
                List<String> answers = getAnswersForQuestion(question1);
                String randomAnswer = getRandomAnswer(answers);
                JTextArea answer1TextArea = new JTextArea(randomAnswer);
                answer1TextArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(answer1TextArea);
                tabbedPane.addTab("câu trả lời", scrollPane);
            }
        });
        question1Panel.add(question1Label);
        question1Panel.add(question1TextField);
        question1Panel.add(question1Button);

        // Thêm các tab vào tabbedPane
        tabbedPane.addTab("Câu hỏi ", null, question1Panel, "Câu hỏi ");

        frame.getContentPane().add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }

    private List<String> getAnswersForQuestion(String question) {
        List<String> answers = answerMap.get(question);
        if (answers != null) {
            return answers;
        } else {
            return List.of(
                    "Xin lỗi, tôi không hiểu câu hỏi của bạn. tôi chỉ hiểu các câu hỏi:\n hello\n;bạn ăn cơm chưa\n chửi cái đầu buồi\n lol\n;xin chào\n có cái con cặc\n cho mình hỏi cái\n bạn có biết nhiều không\n bạn có thể giúp mình được không\n hãy giúp mình vấn đề này\n cai này đơn giản lắm\n không biết nên nói gì\n");
        }
    }

    private String getRandomAnswer(List<String> answers) {
        Random random = new Random();
        int index = random.nextInt(answers.size());
        return answers.get(index);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AlChatProgram();
            }
        });
    }
}
