#!/usr/bin/env bash
# wait-for-it.sh

host_port="$1"
shift
cmd="$@"

# Separar host e porta, caso o host tenha a forma host:porta
host=$(echo $host_port | cut -d ':' -f 1)
port=$(echo $host_port | cut -d ':' -f 2)

# Verificar se a porta está definida
if [ -z "$port" ]; then
  echo "Porta não informada!"
  exit 1
fi

# Aguardar o serviço na porta informada
until nc -z "$host" "$port"; do
  >&2 echo "Aguardando $host:$port..."
  sleep 1
done

>&2 echo "$host:$port está disponível - iniciando comando"
exec $cmd
