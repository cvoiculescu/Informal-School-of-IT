# Docker services (PostgreSQL + pgAdmin)

This setup replaces the previous devcontainer and provides:

- PostgreSQL on `localhost:5432`
- pgAdmin on `http://localhost:5050`

## Initialization scripts (idempotent)

Use one of these scripts from the project root.

### Windows (PowerShell)

```powershell
./scripts/init-postgres.ps1
```

### WSL / Linux / macOS (Bash)

```bash
./scripts/init-postgres.sh
```

The scripts are idempotent and can be run multiple times safely:

- start `postgres` and `pgadmin`
- wait until Postgres is ready
- create/update role `user` with password `P@ssword`
- create database `recipes` if missing
- grant privileges for `user`

## pgAdmin credentials

- Email: `admin@recipes.local`
- Password: `admin`

## App datasource values

The Spring app in `src/main/resources/application.properties` uses:

- URL: `jdbc:postgresql://localhost:5432/recipes`
- Username: `user`
- Password: `P@ssword`

