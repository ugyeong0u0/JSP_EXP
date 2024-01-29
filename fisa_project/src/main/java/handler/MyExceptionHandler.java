//package handler;
//
//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//import fisa.lab.exception.*;
//@ControllerAdvice
//public class MyExceptionHandler {
//	@ExceptionHandler(NotExistExceptions.class)
//	public ModelAndView handleRuntimeException(NotExistExceptions e) {
//		System.out.println("ddddddddddddddd");
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message",e.getMessage());
//		mv.setViewName("showError");
//		return mv;
//	}
//}
