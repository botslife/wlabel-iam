# local
docker network create fencenw
docker build -t wlabel-iam .
docker run --rm --network fencenw -dp 11000:11000 -e POSTGRES_URL=jdbc:postgresql://postgres/fencekc  -e POSTGRES_USER=fenceuser -e POSTGRES_PASS=fencepwd --name wlabel-iam-server wlabel-iam

#development
#replace your

docker volume ls
docker network ls
docker network create nwfence
docker run --name postgres -dp 5555:5432 -e POSTGRES_PASSWORD=fencepwd -e POSTGRES_USER=fenceuser -e POSTGRES_DB=fencekc --network fencenw --network-alias fencepostgres -v postgres_volume:/var/lib/postgresql postgres
# docker build --target development -t wlabel-iam .
docker build -t wlabel-iam .
docker run --rm --network fencenw -dp 11000:11000 --name wlabel-iam-server wlabel-iam