/*
Created By Conner Recoskie
Date: June 15th, 2023
Purpose: This program allows users to search and purchase books from a book store.
It has a database of the books in stock and the respective pdf's. The user can
search for a book, and if it is in stock they can purchase the book and get 
acsess to the digital book link. 
*/

// Importing the packages needed in the program
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FrmBookStore extends javax.swing.JFrame {
    
    ArrayList<String> cart = new ArrayList<>();
    
    // Creating an array list to hold the book titles, prices, and links
    ArrayList<BookEntry> bookList = new ArrayList<>();
    
    // Creating a string variable for the inputted book title
    String bookTitle = null;
    
    // Creating a double variable to hold funds
    double funds = 0;
    
    // Creating a double variable to hold the rounded balance
    double roundedBalance = 0;
    
    // Creating a class to hold the book titles, corresponding prices, and links
    public class BookEntry 
    {
        // Creating private final variables to hold the book details
        private final String bookTitle;
        private final String bookPrice;
        private final String bookLink;

        // Allowing each book to be a seperate entry in the class
        public BookEntry(String bookTitle, String bookPrice, String bookLink)
        {
            this.bookTitle = bookTitle;
            this.bookPrice = bookPrice;
            this.bookLink = bookLink;
        }
        
        // Creating getter methods for book titles, prices, and links
        public String getBookTitle() 
        {
            return bookTitle;
        }
        
        public String getBookPrice()
        {
            return bookPrice;
        }
        
        public String getBookLink()
        {
            return bookLink;
        }
    }

    /*
    Function: linearSearchForTitle
    Purpose: This method uses linear search to search through an array to look for a corresponding book title to the book title provided
    Parameters: ArrayList<BookEntry> bookList, it repersents the array list with the book data. String bookTitle, the retrived user input
    Returns: String
    */
    static public String linearSearchForTitle(ArrayList<BookEntry> bookList, String bookTitle)
    {
        for (BookEntry entry : bookList) 
        {
            if (entry.getBookTitle().equals(bookTitle))
            {
                return entry.getBookTitle();
            }
        }
        return null;
    }

    /*
    Function: linearSearchForPrice
    Purpose: This method uses linear search to search through an array to look for a corresponding book price to the book title provided
    Parameters: ArrayList<BookEntry> bookList, it repersents the array list with the book data. String bookTitle, the retrived user input.
    Returns: String
    */
    static public String linearSearchForPrice(ArrayList<BookEntry> bookList, String bookTitle)
    {
        for (BookEntry entry : bookList) 
        {
            if (entry.getBookTitle().equals(bookTitle))
            {
                return entry.getBookPrice();
            }
        }
        return null;
    }
    
    /*
    Function: totalUpCart
    Purpose: This method loops through the cart arraylist and the booklist arraylist to find the prices of the books in the
             users cart. It tallies up these prices and returns the total price.
    Parameters: ArrayList<BookEntry> bookList, it repersents the array list with the book data. ArrayList<String> cart, the arraylist
                that holds the books the user selected.
    Returns: double
    */
    static public double totalUpCart(ArrayList<BookEntry> bookList, ArrayList<String> cart)
    {
        double balance = 0;
        
        for (String item : cart)
        {
            for (BookEntry entry : bookList)
            {
                if (entry.getBookTitle().equals(item))
                {
                    balance += Double.parseDouble(entry.getBookPrice());
                    break;
                }
            }
        }
        return balance;
    }
    
    /*
    Function: round
    Purpose: This method rounds a given number to two decimal places.
    Parameters: double amount repersents the amount that is going to be rounded.
    Returns: double
    */
    public static double round (double amount)
    {
        amount = amount * 100.0;
        amount = Math.round(amount);
        amount = amount/100.0;
        
        return amount;
    }
    
    public FrmBookStore() {
        initComponents();
        
        // Adding an event listener to lblHyperLink
        lblHyperLink.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHyperLinkMouseClicked(evt);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPane = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblBudget = new javax.swing.JLabel();
        txtBudget = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAddFunds = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        lblDivider = new javax.swing.JLabel();
        btnViewCart = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        btnClearCart = new javax.swing.JButton();
        imgBooks = new javax.swing.JLabel();
        lblHyperLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPane.setBackground(new java.awt.Color(153, 255, 153));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("<html><u>True Classics Book Store</u></html>");

        lblBudget.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblBudget.setText("Please add funds to your account:");

        lblSearch.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        lblSearch.setText("Search For a Classic: ");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAddFunds.setText("Add ");
        btnAddFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFundsActionPerformed(evt);
            }
        });

        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnPurchase.setText("Purchase");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        lblDivider.setText("-----------------------------------------------------------------------");

        btnViewCart.setText("View Cart");
        btnViewCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCartActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        btnClearCart.setText("Clear Cart");
        btnClearCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCartActionPerformed(evt);
            }
        });

        imgBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/books(5).jpg"))); // NOI18N

        lblHyperLink.setForeground(new java.awt.Color(51, 51, 255));
        lblHyperLink.setText("<html><u>See our full collection here</u></html>");

        javax.swing.GroupLayout lblPaneLayout = new javax.swing.GroupLayout(lblPane);
        lblPane.setLayout(lblPaneLayout);
        lblPaneLayout.setHorizontalGroup(
            lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblPaneLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lblPaneLayout.createSequentialGroup()
                        .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClearCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lblPaneLayout.createSequentialGroup()
                        .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lblPaneLayout.createSequentialGroup()
                                .addComponent(lblBudget)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lblPaneLayout.createSequentialGroup()
                                .addComponent(lblSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(lblPaneLayout.createSequentialGroup()
                .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblPaneLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblDivider))
                    .addGroup(lblPaneLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(imgBooks))
                    .addGroup(lblPaneLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblHyperLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblPaneLayout.setVerticalGroup(
            lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBudget)
                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddFunds))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(12, 12, 12)
                .addGroup(lblPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblPaneLayout.createSequentialGroup()
                        .addComponent(btnAddToCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPurchase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit))
                    .addComponent(jScrollPane1))
                .addGap(11, 11, 11)
                .addComponent(lblHyperLink, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imgBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPane, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFundsActionPerformed

        // Error checking the user input
        try
        {
            // Parse the user input
            funds += Double.parseDouble(txtBudget.getText());
            
            // Round the total
            funds = round(funds);
            
            // Outputting a user-friendly message to user
            txtOutput.setText("You now have $" + funds + " in your account.");
            txtOutput.append("\n" + "Happy Reading!");
        }
        catch (NumberFormatException e)
        {
            // Output message to user if invalid input is detected
            txtOutput.setText("Invalid Input");
        }
    }//GEN-LAST:event_btnAddFundsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        BufferedReader br = null;

        try 
        {
            // Opening the file for reading
            br = new BufferedReader(new FileReader("./bookListWithLinks.txt"));
            String line;

            while ((line = br.readLine()) != null)
            {
                // Read the book title
                String theBookTitle = line;

                // Read the book price on the next line
                String bookPrice = br.readLine();
                
                // Read the book link on the next line
                String bookLink = br.readLine();

                // Create a BookEntry object and add it to the list
                BookEntry bookEntry = new BookEntry(theBookTitle, bookPrice, bookLink);
                bookList.add(bookEntry);
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        finally
        {
            try 
            {
                if (br != null)
                {
                    br.close();
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }  
        try
        {
            // Adding the book input to a variable
            bookTitle = txtBookTitle.getText(); 
        }
        catch (NumberFormatException e)
        {
            // Output message to user if invalid input is detected
            txtOutput.setText("Invalid Input");
        }
        
        // Perform linear search on the bookList
        String linearSearchResult = linearSearchForTitle(bookList, bookTitle);
        
        String bookPrice;
        
        // Checking to see if the book was found in the database
        if (linearSearchResult != null)
        {
            // Find the price of the book
            bookPrice = linearSearchForPrice(bookList, linearSearchResult);
            txtOutput.setText("We have this book in stock!" + "\n" + "The price is: " + "$" + String.valueOf(bookPrice));
        }
        else
        {
            // If the book was not found, output a message to the user telling them so
            txtOutput.setText("Sorry we do not have that in stock");
            txtBookTitle.setText(null);
            bookTitle = null;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Exiting the program
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // Resetting the output pane
        txtOutput.setText("");
        if (txtBookTitle.getText() != null && bookTitle != null)
        {
            // Adding the book the user chose to the cart arraylist
            cart.add(bookTitle);
            txtOutput.setText("You added " + bookTitle + " to your cart.");
        }
        else
        {
            txtOutput.setText("Please enter the book name into the text box.");
        }
        
        // Resetting the bookTitle variable
        bookTitle = null;
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnViewCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCartActionPerformed
        // Resettting the output pane
        txtOutput.setText("");
        
        // Getting the total balence of the users cart
        double totalBalance = totalUpCart(bookList, cart);
        
        // Rounding the balence
        roundedBalance = round(totalBalance);
        
        // Confirming that the cart is not empty
        if (!cart.isEmpty())
        {
            // If the cart is not empty, output the users book selection to the GUI
            txtOutput.setText("Your book selection: ");
            txtOutput.append("\n");
            for (int i = 0; i < cart.size(); i++)
            {
                txtOutput.append(cart.get(i) + "\n");
            }
            txtOutput.append("The total cost of your cart is: $" + roundedBalance);
        }
        else if (cart.isEmpty())
        {
            // Outputting a message to the user telling them that their cart is empty
            txtOutput.setText("Your cart is empty!");
        }
    }//GEN-LAST:event_btnViewCartActionPerformed

    private void btnClearCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCartActionPerformed
        // Clearing the users cart
        cart.clear();
        
        // Telling the user that there cart has been cleared
        txtOutput.setText("Your cart has been cleared.");
    }//GEN-LAST:event_btnClearCartActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // Creating a String variable to hold the books link
        String bookLink = "";
        
        // Confirming that the user has enough funds in there account for there books
        if (funds >= roundedBalance)
        {
            // Getting the links for the books in the users cart and adding them to a string
            for (String book : cart)
            {
                for (BookEntry entry: bookList)
                {
                    if (entry.getBookTitle().equals(book))
                    {
                         bookLink += entry.getBookLink() + "\n";
                         break;
                    }
                }
            }
        }
        else
        {
            // If the user does not have enough funds in there account, output a message to the GUI saying so. 
            txtOutput.setText("You dont have enough funds.");
            return;
        }
        
        // Confirming that a link has been found
        if (!bookLink.equals(""))
        {
            // Outputting the links to the books the user "purchased"
            txtOutput.setText("Here are the links to your digital books: " + "\n");
            txtOutput.append(bookLink);
            
            // Subtracting the book costs from the users account
            funds -= roundedBalance;
            
            // Rounding the total amount left over
            funds = round(funds);
            
            // Telling the user the amount of funds they have left over, and outputting a thank you message
            txtOutput.append("You have $" + funds + " dollars left in your account");
            txtOutput.append("\n" + "Thanks for shopping with us!");
            
            // Clearing the users cart
            cart.clear();
        }
        else
        {
            // Outputting a message to the user telling them that they dont have any books in their cart
            txtOutput.setText("You do not have any books in your cart.");
        }
    }
    
    // Making the jlabel a hyperlink
    private void lblHyperLinkMouseClicked(java.awt.event.MouseEvent evt) 
    {
        // Error checking
        if (Desktop.isDesktopSupported()) 
        {
        try 
        {
            // Creating a new file element with the library collection link
            File file = new File("./bookCollection.txt");
            // Adding it to the GUI
            Desktop.getDesktop().open(file);
        }
        catch (IOException ex)
        {
            // If there is an exception, output a message to the GUI saying so
            txtOutput.setText("Error!");
        }
    }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBookStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBookStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBookStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBookStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBookStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFunds;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClearCart;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewCart;
    private javax.swing.JLabel imgBooks;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBudget;
    private javax.swing.JLabel lblDivider;
    private javax.swing.JLabel lblHyperLink;
    private javax.swing.JPanel lblPane;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}
