====
    Copyright (C) 2019 Mike Hummel (mh@mhus.de)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
====

docker run -it --name python -v .../py:/x python:3

docker start -ia python
docker exec -it python /bin/bash

docker rm python

---

docker run -it --name python2 -v .../py:/x python:2

docker start -ia python2
docker exec -it python2 /bin/bash

docker rm python2
