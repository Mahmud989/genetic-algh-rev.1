/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RuntimeExecTest1 {

//	public static void main(String[] args) {
//		try {
//			System.out.println("Opening notepad");
//			Runtime runTime = Runtime.getRuntime();
//			Process process = runTime.exec("notepad");
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Closing notepad");
//			process.destroy();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
    public static void main(String[] args) throws InterruptedException {
        try {
            Process process;
            while (true) {
                StringBuffer sb = new StringBuffer();
                process = Runtime.getRuntime()
                        .exec(String.format("cmd.exe /c tasklist /fi \"imagename eq firefox.exe\""));
                StreamGobbler streamGobbler
                        = new StreamGobbler(process.getInputStream(), (t) -> {
                            sb.append(t.trim());
                        }) {
                };
                new Thread(streamGobbler).start();
                int exitCode = process.waitFor();
                System.out.println("wait");
                System.out.println(sb.toString().startsWith("INFO"));
                if (sb.toString().startsWith("INFO")) {
                    System.out.println("exit");
                    break;
                }
                Thread.sleep(1000);
            }
//            Executors.newSingleThreadExecutor().submit(streamGobbler);
            /// process.destroy();
//    String[] arg = new String[]{"-u root", "-h localhost"};
//
//    try {
//        String ss = null;
//        Runtime obj = null;
//        Process p = Runtime.getRuntime().exec("cmd.exe /c start dir ");
////        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
////        while(r.read()!=-1){
////            System.out.print(r.readLine());
////        }
//        BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
//        writeer.write("dir");
//        writeer.flush();
//        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//        System.out.println("Here is the standard output of the command:\n");
//        while ((ss = stdInput.readLine()) != null) {
//            System.out.println(ss);
//        }
//        System.out.println("Here is the standard error of the command (if any):\n");
//        while ((ss = stdError.readLine()) != null) {
//            System.out.println(ss);
//        }
//
//    } catch (IOException e) {
//        System.out.println("FROM CATCH" + e.toString());
//    }
        } catch (IOException ex) {
            Logger.getLogger(RuntimeExecTest1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

