CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50)  NOT NULL,
    data_aniversario DATE,
    role  VARCHAR(50) NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE barbearias (
    id  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome_barbearia VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    criado_em TIMESTAMP  NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE barbeiros (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cpf VARCHAR(14) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    id_usuario UUID NOT NULL UNIQUE,
    id_barbearia UUID NOT NULL,
    criado_em TIMESTAMP  NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_barbeiro_usuario FOREIGN KEY (id_usuario) REFERENCES users(id),
    CONSTRAINT fk_barbeiro_barbearia FOREIGN KEY (id_barbearia) REFERENCES barbearias(id)
);

CREATE TABLE horario_barbearia (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dia_funcionamento VARCHAR(20) NOT NULL,
    horario_abertura TIME NOT NULL,
    horario_encerramento TIME NOT NULL,
    barbearia_id UUID NOT NULL,
    criado_em TIMESTAMP  NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_horario_barbearia FOREIGN KEY (barbearia_id) REFERENCES barbearias(id)
);

CREATE TABLE horario_barbeiro (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dia_disponivel VARCHAR(20) NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    barbeiro_id UUID NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_horario_barbeiro FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id)
);

CREATE TABLE servicos_barbearia (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome_servico VARCHAR(255) NOT NULL,
    preco_servico DECIMAL(10, 2) NOT NULL,
    descricao_servico TEXT,
    duracao_servico INTEGER NOT NULL,
    barbearia_id UUID NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_servico_barbearia FOREIGN KEY (barbearia_id) REFERENCES barbearias(id)
);

CREATE TABLE agendamento (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dia_agendamento TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    users_id UUID NOT NULL,
    barbeiro_id UUID NOT NULL,
    servico_id  UUID NOT NULL,
    barbearia_id UUID NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_agendamento_usuario  FOREIGN KEY (users_id)    REFERENCES users(id),
    CONSTRAINT fk_agendamento_barbeiro FOREIGN KEY (barbeiro_id)  REFERENCES barbeiros(id),
    CONSTRAINT fk_agendamento_servico  FOREIGN KEY (servico_id)   REFERENCES servicos_barbearia(id),
    CONSTRAINT fk_agendamento_barbearia FOREIGN KEY (barbearia_id) REFERENCES barbearias(id)
);