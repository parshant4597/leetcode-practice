class ATM {
    int[] atm;

    public ATM() {
        atm = new int[5] ;
    }

    public void deposit(int[] bank) {
        int n = bank.length;
        for (int i = 0; i < n; i++) {
        
            atm[i] += bank[i];
        }
        System.out.println(Arrays.toString(atm)); 
    }

    public int[] withdraw(int amount) {
        boolean ans = true;
        int sum = amount;

        for (int i = 4; i >= 0; i--) {
            if (i == 4) {
                int notes = sum % 500;
                int tnotes = sum / 500;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                } else {
                    int diff = tnotes - have;
                    sum = diff * 500 + notes;
                }
            } else if (i == 3) {
                int notes = sum % 200;
                int tnotes = sum / 200;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                } else {
                    int diff = tnotes - have;
                    sum = diff * 200 + notes;
                }

            } else if (i == 2) {
                int notes = sum % 100;
                int tnotes = sum / 100;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                } else {
                    int diff = tnotes - have;
                    sum = diff * 100 + notes;
                }

            } else if (i == 1) {
                int notes = sum % 50;
                int tnotes = sum / 50;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                } else {
                    int diff = tnotes - have;
                    sum = diff * 50 + notes;
                }

            } else {
                int notes = sum % 20;
                int tnotes = sum / 20;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                } else {
                    int diff = tnotes - have;
                    sum = diff * 20 + notes;
                }

            }

        } 
        if (sum != 0) {
            int[] anns = { -1 };
            return anns;

        }
        sum = amount ;  
        int[] newatm = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (i == 4) {
                int notes = sum % 500;
                int tnotes = sum / 500;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                    atm[i]  -= tnotes ; 
                    newatm[i] = tnotes;
                } else {
                    int diff = tnotes - have;
                    atm[i] = 0 ; 
                    newatm[i] = have ; 
                    sum = diff * 500 + notes;
                }
            } else if (i == 3) {
                int notes = sum % 200;
                int tnotes = sum / 200;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                    atm[i]  -= tnotes ; 
                     newatm[i] = tnotes;
                } else {
                    int diff = tnotes - have;
                    atm[i]  = 0 ; 
                     newatm[i] = have ; 
                    sum = diff * 200 + notes;
                }

            } else if (i == 2) {
                int notes = sum % 100;
                int tnotes = sum / 100;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                    atm[i]  -= tnotes ; 
                     newatm[i] = tnotes;
                } else {
                    int diff = tnotes - have;
                    atm[i]  = 0 ; 
                     newatm[i] = have ; 
                    sum = diff * 100 + notes;
                }

            } else if (i == 1) {
                int notes = sum % 50;
                int tnotes = sum / 50;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                     newatm[i] = tnotes; 
                    atm[i]  -= tnotes ; 

                } else {
                    int diff = tnotes - have;
                    atm[i]  = 0 ;
                     newatm[i] = have ; 
                    sum = diff * 50 + notes;
                }

            } else {
                int notes = sum % 20;
                int tnotes = sum / 20;
                int have = atm[i];
                if (have >= tnotes) {
                    sum = notes;
                    atm[i]  -= tnotes ; 
                     newatm[i] = tnotes;
                } else {
                    int diff = tnotes - have;
                    sum = diff * 20 + notes;
                    atm[i]  = 0;
                     newatm[i] = have ; 
                }

            }

        }
        return newatm;  

    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */