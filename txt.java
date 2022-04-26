
                        CREATE TABLE IF NOT EXISTS users (
                            id           INTEGER NOT NULL,
                            area_code    VARCHAR(3) NOT NULL,
                            phone_number VARCHAR(10) NOT NULL,
                            first_name   VARCHAR(20) NOT NULL,
                            last_name    VARCHAR(20) NOT NULL,
                            birth_date   DATE NOT NULL,
                            password     VARCHAR(256) NOT NULL,
                            PRIMARY KEY(id)
                        );

                        CREATE TABLE IF NOT EXISTS accounts (
                            id       INTEGER NOT NULL,
                            `name`   VARCHAR(20),
                            `user`   INTEGER NOT NULL,
                            currency VARCHAR(3) NOT NULL,
                            PRIMARY KEY(id)
                                                      );

                                       CREATE TABLE IF NOT EXISTS currencies (
                                           code VARCHAR(3) NOT NULL,
                                           `name` VARCHAR(100) NOT NULL,
                                           PRIMARY KEY(code)
                        );

                                      CREATE TABLE IF NOT EXISTS deposits (
                                           id        INTEGER NOT NULL,
                                           amount    DECIMAL(15,2) NOT NULL,
                                           `date`     DATE NOT NULL,
                                           account_id INTEGER NOT NULL,
                                           PRIMARY KEY(id)
                        );

                                      CREATE TABLE IF NOT EXISTS transactions (
                                           id        INTEGER NOT NULL,
                                           amount    DECIMAL(15,2) NOT NULL,
                                           `date`    DATE NOT NULL,
                                           sender    INTEGER NOT NULL,
                                           recipient INTEGER NOT NULL,
                                           PRIMARY KEY(id)
                        );

                         ALTER TABLE accounts
                                ADD FOREIGN KEY ( currency )
                                REFERENCES currencies ( code );

                                ALTER TABLE accounts
                                ADD FOREIGN KEY (`user`)
                                REFERENCES users ( id );

                                ALTER TABLE deposits
                                ADD FOREIGN KEY ( account_id )
                                REFERENCES accounts ( id );

                                ALTER TABLE transactions
                                ADD FOREIGN KEY ( recipient )
                                REFERENCES accounts ( id );

                        ALTER TABLE transactions
                        ADD  FOREIGN KEY ( sender )
                        REFERENCES accounts ( id )
