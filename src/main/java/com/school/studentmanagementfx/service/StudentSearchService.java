package com.school.studentmanagementfx.service;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;

public class StudentSearchService {

//  Time Complexity: O(n)
    public static Student findById(String id) {
        for (Student s : StudentRepo.getStudents()) {
            if (s.getId().get().equals(id)) {
                return s;
            }
        }
        return null;
    }
}
