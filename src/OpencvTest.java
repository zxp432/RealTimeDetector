import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class OpencvTest {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
        System.loadLibrary("opencv_java2411");  
        Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);  
        System.out.println("m = " + m.dump()); 
	}

}
