package com.telnet.qcm.controller;

import com.telnet.qcm.entities.QcmJ;
import com.telnet.qcm.entities.QuestionBody;
import com.telnet.qcm.entities.Response;
import com.telnet.qcm.entities.Test;
import com.telnet.qcm.exception.ValidationException;
import com.telnet.qcm.service.QcmJService;
import com.telnet.qcm.service.TestService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    QcmJService qcmJService;
    // @Autowired
    // MyProperties myProperties;

    @RequestMapping(value = ("/allTests"), method = RequestMethod.GET)
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }

    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public ResponseEntity<Test> saveTest(@RequestBody Test test) throws ValidationException {
        if (test.getTitle().isEmpty()) {
            throw new ValidationException("title is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (test.getStatus().isEmpty()) {
            throw new ValidationException("status is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
        if (test.getMax_nb_questions() == null) {
            throw new ValidationException("qcm number is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
        if (test.getTime_limite()==null) {
            throw new ValidationException("time is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }

        if (test.getQcmJs().isEmpty()) {
            throw new ValidationException("Question is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
        testService.saveTest(test);
        return (ResponseEntity.ok(test));
    }

    @RequestMapping(value = "/deleteTest/{id}", method = RequestMethod.DELETE)
    public void removeTest(@PathVariable("id") Long id) throws ValidationException {
        testService.removetest(id);
    }

    @RequestMapping(value = ("/oneTest/{id}"), method = RequestMethod.GET)
    public Test getTest(@PathVariable("id") Long id) {
        return testService.getTestbyid(id);
    }

    @RequestMapping(value = "/updateTest/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Test> updateRole(@RequestBody Test test, @PathVariable long id) throws ValidationException {
        test.setId(id);
        testService.saveTest(test);
        return (ResponseEntity.ok(test));
    }

    @RequestMapping(value = "/createFile", method = RequestMethod.POST)
    public void createFile(@RequestBody Test test)throws IOException {

        String name=test.getTitle();


        FileWriter myWriter = new FileWriter("C:\\Users\\Raoudha\\IdeaProjects\\"+"test_"+name+".php");

         //header of PHP file

        myWriter.write(" <?php\n" +
                "\n" +
                "return array(\n" +
                "    'meta' => array(\n" +
                "        'title' =>");
        myWriter.write("\'" );
        myWriter.write(test.getTitle()+"\',");


        myWriter.write(" \n ");
        myWriter.write("'max_nb_questions' => ");
        myWriter.write(String.valueOf(test.getMax_nb_questions()));
        myWriter.write(" ," );
        myWriter.write(" \n ");
        myWriter.write("'status' => ");
        myWriter.write("\'" );
        myWriter.write(test.getStatus());
        myWriter.write("\'" );
        myWriter.write(" // {'available', 'deactivated', 'hidden'}\n" + "    ) ," );
        myWriter.write(" \n ");

        //Body OF PHP file
        myWriter.write("'questions' =>  array( \n "+"\n");
        List<QcmJ>qcmJS = (List<QcmJ>) test.getQcmJs();
        for(int j=0;j<qcmJS.size();j++){
        QcmJ qcmJ = qcmJS.get(j);
        String tit=qcmJ.getTitle();
        QuestionBody q11 =qcmJ.getQuestionBody() ;
        String q111=q11.getQuestion();
        Document qqq = Jsoup.parse(q111);
        System.out.println(qqq);
        myWriter.write(" array(\n" +
                "            '"+tit+ " ',\n" );

            //with code
            if(qqq.toString().contains("<code>")) {
                Element link = qqq.select("pre").first();

                System.out.println("Text: " + link.text());
                myWriter.write("\"" + link.text() + "\"");


            }

        //Without code
            else {

            Element link = qqq.select("p").first();

            System.out.println("Text: " + link.text());
        myWriter.write("\""+link.text()+"\"");}

        myWriter.write("\n" +
                "                ,\n" +
                "            array(\n" );
            List<Response> reps = (List<Response>) q11.getResponses();
            for(int i =0;i<reps.size()-1;i++)
            {
                Response rep= reps.get(i);
                String label =rep.getLabel();
                String code=rep.getCode();
                String true1 = rep.getCode();
                if(code==   null){
                    myWriter.write("\" " + label + "\" =>" + true1 + "\n");

                }
                else  {
                    myWriter.write("\" " + label +"<code>"+code+ "</code>\" =>" + true1 + "\n");
                }
               }
            Response rep= reps.get(reps.size()-1);
            String label =rep.getLabel();
            String code=rep.getCode();
            String true1 = rep.getCode();
            if(code==   null){
                myWriter.write("\" " + label + "\" =>" + true1 + "\n");

            }
            else  {
                myWriter.write("\" " + label +"<code>"+code+ "</code>\" =>" + true1 + "\n");
            }

            myWriter.write(" ) \n ), \n ");

        }
        //End
        myWriter.write(") \n );");
        System.out.println("Successfully wrote to the file.");
        myWriter.close();
    }}
