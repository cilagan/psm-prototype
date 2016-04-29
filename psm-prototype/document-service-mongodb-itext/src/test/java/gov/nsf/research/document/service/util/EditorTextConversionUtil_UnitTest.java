package gov.nsf.research.document.service.util;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import gov.nsf.resarch.document.service.util.EditorTextConversionUtil;
import gov.nsf.research.document.service.model.EditorFormat;
import gov.nsf.research.document.service.model.EditorText;

public class EditorTextConversionUtil_UnitTest {

	public String editorText = "<p>Here is normal text.&nbsp;<strong>Here is bold text.&nbsp;</strong>Here is another normal text.<em>Here is italicized text.&nbsp;</em><u>Here is underlined text.</u>Here is another normal text.</p>";
	
	/**
	 * 
	 * 	<p> - paragraph
	 * 	&nbsp; - space
	 * 	<strong> - bold
	 * 	<em> - italicized
	 * 	<u> - underlined
	 * 
	 */
	
	@Test
	public void testConvertEditorString(){
		Set<EditorText> textStore = EditorTextConversionUtil.convertEditorString(editorText);
		
		for(EditorText et : textStore){
			System.out.println(et.toString());
		}
	}

	@Test
	public void test() {
		
		String str = "This is String , split by StringTokenizer";
		StringTokenizer st = new StringTokenizer(editorText);

		System.out.println("---- Split by space ------");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("---- Split by comma ',' ------");
		
		String cleaner = (editorText.replaceAll("&nbsp;", " "))
							.replaceAll("<p>", " ")
							.replaceAll("</p>", " ");
		//System.out.println(cleaner);
		//String cleaner2 = cleaner.replaceAll("<p>", " ");
		//System.out.println(cleaner2);
		System.out.println("Input text: " + cleaner);
		StringTokenizer st2 = new StringTokenizer(cleaner, "<>", true);
		
		Set<EditorText> textStore = new LinkedHashSet<EditorText>(); 
		
		while (st2.hasMoreElements()) {
			String text = st2.nextElement().toString();
			System.out.println("text =" + text);
			if("<".equals(text)){
				String inner = st2.nextElement().toString();
				System.out.println(inner);
				
				/** inner tag */
				if("strong".equals(inner)){
					if(">".equals(st2.nextElement())){
						System.out.println("starting tag closing bracket");
					}
					
					String content = st2.nextElement().toString();
					System.out.println("This should be bold = " + content);
					EditorText boldText = new EditorText(content, EditorFormat.BOLD);
					textStore.add(boldText);
					
					String outertag = st2.nextElement().toString();
					
					if("<".equals(outertag)){
						System.out.println("starting outer tag");
						if("/strong".equals(st2.nextElement())){
							System.out.println("this is a strong closing statement");
							if(">".equals(st2.nextElement())){
								System.out.println("outer tag closing bracket");
							}
						}
					}	
				} else if("em".equals(inner)){
					if(">".equals(st2.nextElement())){
						System.out.println("starting tag closing bracket");
					}
					
					String content = st2.nextElement().toString();
					System.out.println("This should be italic = " + content);
					EditorText italicText = new EditorText(content, EditorFormat.ITALIC);
					textStore.add(italicText);
					
					String outertag = st2.nextElement().toString();
					
					if("<".equals(outertag)){
						System.out.println("starting outer tag");
						if("/em".equals(st2.nextElement())){
							System.out.println("this is a italics closing statement");	
						} if(">".equals(st2.nextElement())){
							System.out.println("outer tag closing bracket");
						}
					}
				} else if("u".equals(inner)){
					
					if(">".equals(st2.nextElement())){
						System.out.println("starting tag closing bracket");
					}
					
					String content = st2.nextElement().toString();
					System.out.println("This should be underlined = " + content);
					EditorText underlinedText = new EditorText(content, EditorFormat.UNDERLINED);
					textStore.add(underlinedText);
					
					String outertag = st2.nextElement().toString();
					
					if("<".equals(outertag)){
						System.out.println("starting outer tag");
						if("/u".equals(st2.nextElement())){
							System.out.println("this is a underlined closing statement");
							if(">".equals(st2.nextElement())){
								System.out.println("outer tag closing bracket");
							}
						}
					}
				}
			} else {
				System.out.println("Normal Text = " + text);
				EditorText normalText = new EditorText(text, EditorFormat.PLAIN);
				textStore.add(normalText);
			}
			
			
		}
		
		
		for(EditorText et : textStore){
			System.out.println(et.toString());
		}
		

	}
	
	@Test
	public void testPatternMatcher(){
	    
		String stringToSearch = "<p>Yada yada yada <code>foo</code> yada yada ...\n"
	    	      + "more here <em>bar</em> etc etc\n"
	    	      + "and still more <code>baz</code> and now the end</p>\n";
	    	 
	    	    // the pattern we want to search for
	    	    Pattern p = Pattern.compile(" <em>(\\w+)</em> ", Pattern.MULTILINE);
	    	    Matcher m = p.matcher(stringToSearch);
	    	 
	    	    // print all the matches that we find
	    	    while (m.find())
	    	    {
	    	      System.out.println(m.group(1));
	    	    }
	}
	
	@Test
	public void dataStructure(){
		Set<EditorText> storage = new LinkedHashSet<EditorText>();
		
		EditorText text0 = new EditorText("Here is normal text.", EditorFormat.PLAIN);
		EditorText text1 = new EditorText("Here is bold text.", EditorFormat.BOLD);
		
		storage.add(text0);
		storage.add(text1);
		
		for(EditorText et : storage){
			System.out.println(et.toString());
		}
	}
	
	
}