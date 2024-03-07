package com.spring.excel2database.service;

import com.spring.excel2database.entity.Account;
import com.spring.excel2database.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;

@Service
public class AccountService {

    @Autowired
    private AccountRepository userRepository;

    public void saveUsersFromExcel(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        // İlk satırı başlık satırı olarak atla
        if (iterator.hasNext()) {
            iterator.next();
        }
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            String username = "";
            String password = "";
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                int columnIndex = currentCell.getColumnIndex();
                if (columnIndex == 0) {
                    username = currentCell.getStringCellValue();
                } else if (columnIndex == 1) {
                    password = currentCell.getStringCellValue();
                }
            }
            if (!username.isEmpty() && !password.isEmpty()) {
                Account user = new Account();
                user.setUsername(username);
                user.setPassword(password);
                userRepository.save(user);
            }
        }
        workbook.close();
    }
}
