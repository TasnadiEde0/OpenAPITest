package org.learning.openApiTest;

import lombok.extern.slf4j.Slf4j;
import org.learning.openApiTest.rest.ApiException;
import org.learning.openApiTest.rest.api.DefaultApi;
import org.learning.openApiTest.rest.model.StudentObject;

import java.util.List;

@Slf4j
public class ClientMain {
    public static void main(String[] args) throws Exception {
        DefaultApi defaultApi = new DefaultApi();
        List<StudentObject> students = defaultApi.studentGet();
        log.info("{}", students);

    }
}
