import java.io.*;
import java.util.*;

public class Main {
    static final Map<String, String> OPCODE_MAP = Map.ofEntries(
        Map.entry("ADD", "00000"),
        Map.entry("ADDC", "00001"),
        Map.entry("SUB", "00010"),
        Map.entry("SUBC", "00011"),
        Map.entry("MOV", "00100"),
        Map.entry("MOVC", "00101"),
        Map.entry("AND", "00110"),
        Map.entry("ANDC", "00111"),
        Map.entry("OR", "01000"),
        Map.entry("ORC", "01001"),
        Map.entry("NOT", "01010"),
        Map.entry("MULT", "01100"),
        Map.entry("MULTC", "01101"),
        Map.entry("LSFTL", "01110"),
        Map.entry("LSFTLC", "01111"),
        Map.entry("LSFTR", "10000"),
        Map.entry("LSFTRC", "10001"),
        Map.entry("ASFTR", "10010"),
        Map.entry("ASFTRC", "10011"),
        Map.entry("RL", "10100"),
        Map.entry("RLC", "10101"),
        Map.entry("RR", "10110"),
        Map.entry("RRC", "10111")
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            String last = st.nextToken();

            boolean usesConst = opcode.endsWith("C");

            StringBuilder sb = new StringBuilder();
            sb.append(OPCODE_MAP.get(opcode));       
            sb.append("0");                           
            sb.append(toBits(rD, 3));                 
            sb.append(toBits(rA, 3));                

            if (usesConst) {
                int constant = Integer.parseInt(last);
                sb.append(toBits(constant, 4));       
            } else {
                int rB = Integer.parseInt(last);
                sb.append(toBits(rB, 3));             
                sb.append("0");                        
            }

            System.out.println(sb);
        }
    }

    static String toBits(int num, int len) {
        String bin = Integer.toBinaryString(num);
        while (bin.length() < len) bin = "0" + bin;
        return bin;
    }
}
